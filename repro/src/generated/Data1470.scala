package generated

final case class Data1470(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1470 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1470 = copy(value = value * k)
  def addTag(t: String): Data1470 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1470 = copy(meta = meta.updated(k, v))
  def merge(other: Data1470): Data1470 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1470 {
  given Ordering[Data1470] = Ordering.by(_.id)
  def empty: Data1470 = Data1470(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1470 =
    Data1470(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1470] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
