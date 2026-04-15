package generated

final case class Data441(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data441 = copy(name = name.toUpperCase)
  def scale(k: Double): Data441 = copy(value = value * k)
  def addTag(t: String): Data441 = copy(tags = t :: tags)
  def put(k: String, v: String): Data441 = copy(meta = meta.updated(k, v))
  def merge(other: Data441): Data441 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data441 {
  given Ordering[Data441] = Ordering.by(_.id)
  def empty: Data441 = Data441(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data441 =
    Data441(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data441] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
