package generated

final case class Data1078(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1078 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1078 = copy(value = value * k)
  def addTag(t: String): Data1078 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1078 = copy(meta = meta.updated(k, v))
  def merge(other: Data1078): Data1078 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1078 {
  given Ordering[Data1078] = Ordering.by(_.id)
  def empty: Data1078 = Data1078(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1078 =
    Data1078(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1078] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
