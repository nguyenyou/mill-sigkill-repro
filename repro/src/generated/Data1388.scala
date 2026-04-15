package generated

final case class Data1388(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1388 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1388 = copy(value = value * k)
  def addTag(t: String): Data1388 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1388 = copy(meta = meta.updated(k, v))
  def merge(other: Data1388): Data1388 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1388 {
  given Ordering[Data1388] = Ordering.by(_.id)
  def empty: Data1388 = Data1388(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1388 =
    Data1388(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1388] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
