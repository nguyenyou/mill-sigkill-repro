package generated

final case class Data205(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data205 = copy(name = name.toUpperCase)
  def scale(k: Double): Data205 = copy(value = value * k)
  def addTag(t: String): Data205 = copy(tags = t :: tags)
  def put(k: String, v: String): Data205 = copy(meta = meta.updated(k, v))
  def merge(other: Data205): Data205 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data205 {
  given Ordering[Data205] = Ordering.by(_.id)
  def empty: Data205 = Data205(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data205 =
    Data205(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data205] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
