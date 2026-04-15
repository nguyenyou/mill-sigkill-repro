package generated

final case class Data589(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data589 = copy(name = name.toUpperCase)
  def scale(k: Double): Data589 = copy(value = value * k)
  def addTag(t: String): Data589 = copy(tags = t :: tags)
  def put(k: String, v: String): Data589 = copy(meta = meta.updated(k, v))
  def merge(other: Data589): Data589 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data589 {
  given Ordering[Data589] = Ordering.by(_.id)
  def empty: Data589 = Data589(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data589 =
    Data589(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data589] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
