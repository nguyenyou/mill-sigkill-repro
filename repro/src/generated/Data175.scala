package generated

final case class Data175(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data175 = copy(name = name.toUpperCase)
  def scale(k: Double): Data175 = copy(value = value * k)
  def addTag(t: String): Data175 = copy(tags = t :: tags)
  def put(k: String, v: String): Data175 = copy(meta = meta.updated(k, v))
  def merge(other: Data175): Data175 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data175 {
  given Ordering[Data175] = Ordering.by(_.id)
  def empty: Data175 = Data175(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data175 =
    Data175(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data175] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
