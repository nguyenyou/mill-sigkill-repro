package generated

final case class Data886(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data886 = copy(name = name.toUpperCase)
  def scale(k: Double): Data886 = copy(value = value * k)
  def addTag(t: String): Data886 = copy(tags = t :: tags)
  def put(k: String, v: String): Data886 = copy(meta = meta.updated(k, v))
  def merge(other: Data886): Data886 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data886 {
  given Ordering[Data886] = Ordering.by(_.id)
  def empty: Data886 = Data886(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data886 =
    Data886(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data886] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
