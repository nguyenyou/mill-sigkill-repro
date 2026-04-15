package generated

final case class Data990(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data990 = copy(name = name.toUpperCase)
  def scale(k: Double): Data990 = copy(value = value * k)
  def addTag(t: String): Data990 = copy(tags = t :: tags)
  def put(k: String, v: String): Data990 = copy(meta = meta.updated(k, v))
  def merge(other: Data990): Data990 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data990 {
  given Ordering[Data990] = Ordering.by(_.id)
  def empty: Data990 = Data990(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data990 =
    Data990(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data990] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
