package generated

final case class Data198(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data198 = copy(name = name.toUpperCase)
  def scale(k: Double): Data198 = copy(value = value * k)
  def addTag(t: String): Data198 = copy(tags = t :: tags)
  def put(k: String, v: String): Data198 = copy(meta = meta.updated(k, v))
  def merge(other: Data198): Data198 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data198 {
  given Ordering[Data198] = Ordering.by(_.id)
  def empty: Data198 = Data198(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data198 =
    Data198(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data198] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
