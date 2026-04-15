package generated

final case class Data1406(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1406 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1406 = copy(value = value * k)
  def addTag(t: String): Data1406 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1406 = copy(meta = meta.updated(k, v))
  def merge(other: Data1406): Data1406 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1406 {
  given Ordering[Data1406] = Ordering.by(_.id)
  def empty: Data1406 = Data1406(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1406 =
    Data1406(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1406] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
