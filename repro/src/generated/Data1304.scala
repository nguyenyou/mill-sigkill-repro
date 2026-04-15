package generated

final case class Data1304(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1304 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1304 = copy(value = value * k)
  def addTag(t: String): Data1304 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1304 = copy(meta = meta.updated(k, v))
  def merge(other: Data1304): Data1304 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1304 {
  given Ordering[Data1304] = Ordering.by(_.id)
  def empty: Data1304 = Data1304(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1304 =
    Data1304(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1304] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
