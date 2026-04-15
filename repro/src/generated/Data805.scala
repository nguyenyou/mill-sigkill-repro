package generated

final case class Data805(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data805 = copy(name = name.toUpperCase)
  def scale(k: Double): Data805 = copy(value = value * k)
  def addTag(t: String): Data805 = copy(tags = t :: tags)
  def put(k: String, v: String): Data805 = copy(meta = meta.updated(k, v))
  def merge(other: Data805): Data805 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data805 {
  given Ordering[Data805] = Ordering.by(_.id)
  def empty: Data805 = Data805(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data805 =
    Data805(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data805] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
