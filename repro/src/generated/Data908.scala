package generated

final case class Data908(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data908 = copy(name = name.toUpperCase)
  def scale(k: Double): Data908 = copy(value = value * k)
  def addTag(t: String): Data908 = copy(tags = t :: tags)
  def put(k: String, v: String): Data908 = copy(meta = meta.updated(k, v))
  def merge(other: Data908): Data908 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data908 {
  given Ordering[Data908] = Ordering.by(_.id)
  def empty: Data908 = Data908(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data908 =
    Data908(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data908] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
