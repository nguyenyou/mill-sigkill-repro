package generated

final case class Data597(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data597 = copy(name = name.toUpperCase)
  def scale(k: Double): Data597 = copy(value = value * k)
  def addTag(t: String): Data597 = copy(tags = t :: tags)
  def put(k: String, v: String): Data597 = copy(meta = meta.updated(k, v))
  def merge(other: Data597): Data597 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data597 {
  given Ordering[Data597] = Ordering.by(_.id)
  def empty: Data597 = Data597(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data597 =
    Data597(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data597] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
