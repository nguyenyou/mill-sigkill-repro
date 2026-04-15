package generated

final case class Data1424(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1424 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1424 = copy(value = value * k)
  def addTag(t: String): Data1424 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1424 = copy(meta = meta.updated(k, v))
  def merge(other: Data1424): Data1424 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1424 {
  given Ordering[Data1424] = Ordering.by(_.id)
  def empty: Data1424 = Data1424(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1424 =
    Data1424(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1424] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
