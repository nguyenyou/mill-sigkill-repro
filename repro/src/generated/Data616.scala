package generated

final case class Data616(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data616 = copy(name = name.toUpperCase)
  def scale(k: Double): Data616 = copy(value = value * k)
  def addTag(t: String): Data616 = copy(tags = t :: tags)
  def put(k: String, v: String): Data616 = copy(meta = meta.updated(k, v))
  def merge(other: Data616): Data616 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data616 {
  given Ordering[Data616] = Ordering.by(_.id)
  def empty: Data616 = Data616(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data616 =
    Data616(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data616] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
