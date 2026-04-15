package generated

final case class Data384(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data384 = copy(name = name.toUpperCase)
  def scale(k: Double): Data384 = copy(value = value * k)
  def addTag(t: String): Data384 = copy(tags = t :: tags)
  def put(k: String, v: String): Data384 = copy(meta = meta.updated(k, v))
  def merge(other: Data384): Data384 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data384 {
  given Ordering[Data384] = Ordering.by(_.id)
  def empty: Data384 = Data384(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data384 =
    Data384(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data384] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
