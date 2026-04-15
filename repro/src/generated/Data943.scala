package generated

final case class Data943(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data943 = copy(name = name.toUpperCase)
  def scale(k: Double): Data943 = copy(value = value * k)
  def addTag(t: String): Data943 = copy(tags = t :: tags)
  def put(k: String, v: String): Data943 = copy(meta = meta.updated(k, v))
  def merge(other: Data943): Data943 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data943 {
  given Ordering[Data943] = Ordering.by(_.id)
  def empty: Data943 = Data943(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data943 =
    Data943(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data943] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
