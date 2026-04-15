package generated

final case class Data1247(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1247 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1247 = copy(value = value * k)
  def addTag(t: String): Data1247 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1247 = copy(meta = meta.updated(k, v))
  def merge(other: Data1247): Data1247 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1247 {
  given Ordering[Data1247] = Ordering.by(_.id)
  def empty: Data1247 = Data1247(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1247 =
    Data1247(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1247] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
