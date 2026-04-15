package generated

final case class Data1049(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1049 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1049 = copy(value = value * k)
  def addTag(t: String): Data1049 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1049 = copy(meta = meta.updated(k, v))
  def merge(other: Data1049): Data1049 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1049 {
  given Ordering[Data1049] = Ordering.by(_.id)
  def empty: Data1049 = Data1049(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1049 =
    Data1049(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1049] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
